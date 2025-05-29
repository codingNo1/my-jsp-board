package com.library.notice.controller;

import com.library.notice.model.Notice;
import com.library.notice.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/notice"})
public class NoticeController {
  @Autowired
  public NoticeService noticeService;
  
  @GetMapping({"/list"})
  public String list(Model model) {
    model.addAttribute("noticelist", this.noticeService.findAll());
    return "notice/list";
  }
  
  @GetMapping({"/detail"})
  public String detail(@RequestParam(value = "num", required = false) Long num, Model model) {
    Notice notice = this.noticeService.findByNum(num);
    model.addAttribute("notice", notice);
    return "notice/detail";
  }
  
  @GetMapping({"/write"})
  public String writeform() {
    return "notice/write";
  }
  
  @PostMapping({"write"})
  public String writeSubmit(Notice notice, HttpSession session) {
    Boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
    if (isAdmin == null || !isAdmin.booleanValue())
      return "redirect:/notice/list"; 
    this.noticeService.write(notice);
    return "redirect:/notice/list";
  }
  
  @GetMapping({"/update"})
  public String update(@RequestParam("num") Long num, Model model) {
    Notice notice = this.noticeService.findByNum(num);
    model.addAttribute("notice", notice);
    return "notice/update";
  }
  
  @PostMapping({"/update"})
  public String updatesubmit(@ModelAttribute Notice notice) {
    this.noticeService.update(notice);
    return "redirect:/notice/detail?num=" + String.valueOf(notice.getNum());
  }
  
  @GetMapping({"/delete"})
  public String delete(@RequestParam("num") Long num) {
    this.noticeService.delete(num);
    return "redirect:/notice/list";
  }
  
  @GetMapping({"/admin-login"})
  public String adminloginForm() {
    return "notice/admin-login";
  }
  
  @PostMapping({"/admin-login"})
  public String adminloginSubmit(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, Model model) {
    if ("admin".equals(username) && "9876".equals(password)) {
      session.setAttribute("isAdmin", Boolean.valueOf(true));
      return "redirect:/notice/list";
    } 
    model.addAttribute("error", ");
    return "notice/admin-login";
  }
  
  @GetMapping({"/admin-logout"})
  public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
    session.invalidate();
    redirectAttributes.addFlashAttribute("logoutmessage", ");
    return "redirect:/notice/list";
  }
}
