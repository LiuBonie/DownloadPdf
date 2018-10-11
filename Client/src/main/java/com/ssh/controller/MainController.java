package com.ssh.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.mina.filter.reqres.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.ssh.person.Person;
import com.ssh.service.PersonService;
import com.ssh.service.PersonServiceImplService;

@Controller
public class MainController {
	
	
	private PersonService PersonService;
	public MainController(){

//		PersonServiceImplService psi = new PersonServiceImplService();
//		PersonService = psi.getPersonServiceImplPort();
		
		
		   JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

	       factory.setServiceClass(PersonService.class);

	    factory.setAddress("http://localhost:8080/sshTO/cxf/testService?wsdl");

	    PersonService = (PersonService) factory.create();
	    //在linux中加这个会报错
	   /* Client client = ClientProxy.getClient (8080);
	    HTTPConduit http = (HTTPConduit) client.getConduit();	    
	    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(36000 );
        httpClientPolicy.setAllowChunking( false ); 
        httpClientPolicy.setReceiveTimeout(32000 );
        http.setClient(httpClientPolicy);*/

	}
	 
	@RequestMapping("info")
	public String query(HttpServletRequest request,@RequestParam String Name,String Start,String End,String Location,String PrintTime,String Room,String Folio,String Days) {
		System.out.println("guo来了");
//		SimpleDateFormat sf = new SimpleDateFormat("MM/dd/YYYY ");
		HttpSession session = request.getSession(true);
		session.removeAttribute("Msg");
		com.ssh.person.Person p = new com.ssh.person.Person();
		p.setName(Name);
		p.setEnd(End);
		p.setStart(Start);
		
		p.setLocation(Location);
		PrintTime = PrintTime.replaceAll("凌晨", "上午");
		PrintTime = PrintTime.replaceAll("早上", "上午");
		PrintTime = PrintTime.replaceAll("中午", "上午");
		PrintTime = PrintTime.replaceAll("晚上", "下午");
		p.setPrintTime(PrintTime);
		p.setRoom(Room);
		try {
		p.setFolio(Long.parseLong(Folio));
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("Msg", "请填写正确的Folio");
			return "SPerson";
		}
		p.setDays(Days);
		PersonService.saveOrUpdate(p);
		session.setAttribute("msg", "第saveOrUpdate号录入成功");
//		System.out.println(num);
		return "OK";
		
	}
	
	@RequestMapping("findInfo")
	public String findInfo(Model model,HttpServletRequest request) {
		System.out.println("find来了");
		
		HttpSession session = request.getSession(true);
		session.removeAttribute("Msg");
		List<com.ssh.person.Person> list =  PersonService.findAll();
		if(list==null) {
			session.setAttribute("Msg", "无数据");
			return "FPerson";
		}
		model.addAttribute("Personlist", list);
		System.out.println(list.size());
		return "FPerson";
	}
	
	
	@RequestMapping("delInfo")
	public String delInfo(Model model,HttpServletRequest request) {
		System.out.println("del来了");
		
		HttpSession session = request.getSession(true);
		session.removeAttribute("Msg");
		System.out.println(request.getParameter("id"));
		Long id  = Long.parseLong(request.getParameter("id"));
		try {
			PersonService.delete(id);
			session.setAttribute("Msg", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("Msg", "删除失败");
			return "FPerson";
		}finally {
			List<com.ssh.person.Person> list =  PersonService.findAll();
			model.addAttribute("Personlist", list);

		}
		return "FPerson";
	}
	
	
	@RequestMapping("updateInfo")
	public String updateInfo(Model model,HttpServletRequest request,@RequestParam String Name,String Start,String End,String Location,String PrintTime,String Room,String Folio,String Days) {
		System.out.println("update来了");
		
		HttpSession session = request.getSession(true);
		session.removeAttribute("uMsg");
		Long id  = Long.parseLong(request.getParameter("ID"));
		Person p = new Person();
		p.setId(id);
		p.setName(Name);
		p.setEnd(End);
		p.setStart(Start);
		
		p.setLocation(Location);
		PrintTime = PrintTime.replaceAll("凌晨", "上午");
		PrintTime = PrintTime.replaceAll("早上", "上午");
		PrintTime = PrintTime.replaceAll("中午", "上午");
		PrintTime = PrintTime.replaceAll("晚上", "下午");
		p.setPrintTime(PrintTime);
		p.setRoom(Room);
		try {
		p.setFolio(Long.parseLong(Folio));
		}catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("uMsg", "请填写正确的Folio");
			return "SPerson";
		}
		p.setDays(Days);
	System.out.println(p.getName());
		try {
			PersonService.saveOrUpdate(p);
			System.out.println(p.getName());
			session.setAttribute("updateMsg", "更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("updateMsg", "更新失败");
			return "FPerson";
		}finally {
			List<Person> list =  PersonService.findAll();
			model.addAttribute("Personlist", list);

		}
		return "FPerson";
	}

	@RequestMapping("pdf")
	public void  pdf(Model model,HttpServletRequest request,HttpServletResponse response,@RequestParam Long id) throws FileNotFoundException, DocumentException, IOException, ParseException {
		//通過id獲取相應數據
		com.ssh.person.Person p = PersonService.findById(id);
		
		 //example inspired from "iText in action" (2006), chapter 2 
		 
//        PdfReader reader = new PdfReader("E:/liuzibo/workshop/Service/src/main/resources/pdf.pdf"); // input PDF
		 PdfReader reader = new PdfReader("D:/liuzibo/workshop/Service/src/main/resources/pdf.pdf"); // input PDF
//        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfStamper stamper = new PdfStamper(reader,
        		new FileOutputStream("D:/pdf"+id+".pdf")); // output PDF
        BaseFont bf = BaseFont.createFont(
                BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font
//        Embedded font：font(Horizontal)
        
        //loop on pages (1-based)
        for (int i=1; i<=reader.getNumberOfPages(); i++){
 
            // get object for writing over the existing content;
            // you can also use getUnderContent for writing in the bottom layer
            PdfContentByte over = stamper.getOverContent(i);
 
            // write text
            //左上角
            over.beginText();
            over.setFontAndSize(bf, 10);    // set font and size
            over.setTextMatrix(19, 765);   // set x,y position (0,0 is at the bottom left)
            Date date = new SimpleDateFormat("yyyy-MM-dd hh:mm aa",Locale.CHINA).parse(p.getPrintTime()); 
      	  	String now = new SimpleDateFormat("MM/dd/yyyy hh:mm aa",Locale.ENGLISH).format(date);
            over.showText(now);  // set text
            over.endText();
            //from  through 
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(220, 680);   
            over.showText("From "+p.getStart()+" Through "+p.getEnd());  
            over.endText();
            //Folio
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(31, 648);   
            over.showText("Folio # "+p.getFolio());  
            over.endText();
            //Name
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(31, 635);   
            over.showText(p.getName());  
            over.endText();
            //Room
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(530, 647);   
            over.showText(p.getRoom());  
            over.endText();
            //start
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(530, 633);   
            over.showText(p.getStart());  
            over.endText();
            //end
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(530, 620);   
            over.showText(p.getEnd());  
            over.endText();
            //$0.00
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(551, 519);   
            over.showText("$0.00");  
            over.endText();
            //金额数字处理
            DecimalFormat df = new DecimalFormat();
            String style = "#,###.00";//定义要显示的数字的格
    		df.applyPattern(style);// 将格式应用于格式化器
//    		int day = Integer.parseInt(p.getDays());
//    		double d  = (62.37-7.79625)*Integer.parseInt(p.getDays());		
//    		String result = df.format(d).toString();
//    	     double d1  = 7.79625*Integer.parseInt(p.getDays());
//    	     double d2 = d1 +d;
//    	     System.out.println(d2);
//             String result1 = df.format(d1).toString();
//             String result2 = df.format(d2);
    		//对于DAYs的计算
    		
    		String start = p.getStart();
    		String end = p.getEnd();
    		DateFormat in = new SimpleDateFormat("MM/dd/yyyy");
    		Date dateStart =  in.parse(start);
    		Date dateEnd =  in.parse(end);	
    		long days = dateEnd.getTime() - dateStart.getTime();
    		long day = (days / (1000 * 60 * 60 * 24)); 


			double TaxInclusice =Double.parseDouble (p.getDays());
			double total = TaxInclusice*day;
			double taxbefore = total/1.125;
			
			
//    		 BigDecimal less = new BigDecimal(day*TaxInclusice).
//    	             setScale(2, BigDecimal.ROUND_DOWN);
    	            BigDecimal tax = new BigDecimal(day*7.79625)
    	              .setScale(2, BigDecimal.ROUND_DOWN);
    	            
    	            BigDecimal room = new BigDecimal(day*(TaxInclusice - 7.79625))
    	              .setScale(2, BigDecimal.ROUND_DOWN);
    	            BigDecimal less = new BigDecimal(0).
    	    	             setScale(2, BigDecimal.ROUND_DOWN);
    	            less = tax.add(room);
            String Sless = df.format(less).toString();
            String Stax = df.format(tax).toString();
            String SRoom = df.format(room).toString();
             //
             int Rlength = SRoom.length();
             int Rx = this.getX(Rlength);
             int Tlength = Stax.length();
             int Tx = this.getX(Tlength);
             int Llength = Sless.length();
             int Lx = this.getX(Llength);
            System.out.println(room);
            System.out.println(less);
            System.out.println(tax);
            //Room Charges:
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(Rx, 506);  
            over.showText("$"+SRoom);  
            over.endText();
            //$0.00
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(551, 493);   
            over.showText("$0.00");  
            over.endText();
            //$0.00
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(551, 480);   
            over.showText("$0.00");  
            over.endText();
            //Tax
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(Tx, 466); 
       
            over.showText("$"+Stax);  
            over.endText();
          //Less Payments
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(Lx, 453);             
            
            over.showText("$"+Sless);  
            over.endText();
          //$0.00
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(551, 421);   
            over.showText("$0.00");  
            over.endText();
            
//            // draw a red circle
//            over.setRGBColorStroke(0xFF, 0x00, 0x00);
//            over.setLineWidth(5f);
//            over.ellipse(250, 450, 350, 550);
//            over.stroke();
        }
 
        stamper.close();
        try {
            // path是指欲下载的文件的路径。
            File file = new File("D:/pdf"+id+".pdf");
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();
       
            // 以流的形式下载文件。
            //把输出流转为输入流
//            ByteArrayInputStream fis = new ByteArrayInputStream(out.toByteArray())  ;
            InputStream fis = new BufferedInputStream(new FileInputStream("D:/pdf"+id+".pdf"));
            byte[] buffer = new byte[fis.available()];
            
            fis.read(buffer);
            fis.close();
           
          
            
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if (file.exists() && file.isFile()) {
                if (file.delete()) {
                    System.out.println("删除单个文件" + filename + "成功！");
                } else {
                    System.out.println("删除单个文件" + filename + "失败！");
                }
            } else {
                System.out.println("删除单个文件失败：" + filename + "不存在！");
            }
          } catch (IOException ex) {
            ex.printStackTrace();
          }
       
	}
	private int getX(int length) {
		int x;
		if(length==5) {
			x= 546;
			return x;
		}else if(length==6) {
			x=540;
			return x;
		}else if(length==8) {
			x=532;
			return x;
		}
		return 0;
	}
}
