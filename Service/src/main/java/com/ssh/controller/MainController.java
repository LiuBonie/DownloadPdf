package com.ssh.controller;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.ssh.entity.Person;
import com.ssh.service.PersonService;

@Controller
public class MainController {

	@Autowired
	private PersonService PersonService ;
	
	@RequestMapping("info")
	public String query(HttpServletRequest request,@RequestParam String Name,String Start,String End,String Location,String PrintTime,String Room,String Folio,String Days) {
		System.out.println("guo来了");
//		SimpleDateFormat sf = new SimpleDateFormat("MM/dd/YYYY ");
		HttpSession session = request.getSession(true);
		session.removeAttribute("Msg");
		Person p = new Person();
		p.setName(Name);
		p.setEnd(End);
		p.setStart(Start);
		
		p.setLocation(Location);
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
		Long num =  PersonService.savePerson(p);
		session.setAttribute("msg", "第"+num+"号录入成功");
		System.out.println(num);
		return "OK";
		
	}
	
	@RequestMapping("findInfo")
	public String findInfo(Model model,HttpServletRequest request) {
		System.out.println("find来了");
		HttpSession session = request.getSession(true);
		session.removeAttribute("findMsg");
		List<Person> list =  PersonService.findAll();
		if(list==null) {
			session.setAttribute("findMsg", "无数据");
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
		session.removeAttribute("delInfo");
		System.out.println(request.getParameter("id"));
		Long id  = Long.parseLong(request.getParameter("id"));
		try {
			PersonService.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("delInfo", "删除失败");
			return "FPerson";
		}finally {
			List<Person> list =  PersonService.findAll();
			model.addAttribute("Personlist", list);

		}
		return "FPerson";
	}

	@RequestMapping("pdf")
	public String pdf(Model model,HttpServletRequest request,@RequestParam Long id) throws FileNotFoundException, DocumentException, IOException {
		//通過id獲取相應數據
		Person p = PersonService.FindById(id);
		
		/* example inspired from "iText in action" (2006), chapter 2 */
		 
        PdfReader reader = new PdfReader("E:/liuzibo/workshop/SSH-day01/src/main/resources/pdf.pdf"); // input PDF
        PdfStamper stamper = new PdfStamper(reader,
          new FileOutputStream("E:/pdf_copy"+id+".pdf")); // output PDF
        //
        
        BaseFont bf = BaseFont.createFont(
                BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set font
 
        //loop on pages (1-based)
        for (int i=1; i<=reader.getNumberOfPages(); i++){
 
            // get object for writing over the existing content;
            // you can also use getUnderContent for writing in the bottom layer
            PdfContentByte over = stamper.getOverContent(i);
 
            // write text
            //左上角
            over.beginText();
            over.setFontAndSize(bf, 10);    // set font and size
            over.setTextMatrix(20, 765);   // set x,y position (0,0 is at the bottom left)
            over.showText(p.getPrintTime());  // set text
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
            over.setTextMatrix(33, 645);   
            over.showText("Folio # "+p.getFolio());  
            over.endText();
            //Name
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(33, 632);   
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
          //Room Charges:
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(530, 506);   
            over.showText("$1,627.24");  
            over.endText();
          //Tax
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(540, 466);   
            over.showText("$200.99");  
            over.endText();
          //Less Payments
            over.beginText();
            over.setFontAndSize(bf, 10);    
            over.setTextMatrix(530, 453);   
            over.showText("$1,827.23");  
            over.endText();
/*            // draw a red circle
            over.setRGBColorStroke(0xFF, 0x00, 0x00);
            over.setLineWidth(5f);
            over.ellipse(250, 450, 350, 550);
            over.stroke();*/
        }
 
        stamper.close();
 
	        return "FPerson";
	}
	
}
