package com.example.card.Controller;

import com.example.card.Service.CardtableService;
import com.example.card.Vo.CardtableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("/Card")
@RestController
public class CardtableController {

    @Autowired
    private CardtableService cardtableService;

    @PostMapping("/submit")
    Object card_submit(@RequestBody CardtableVo cardtableVo) {
        return cardtableService.card_submit(cardtableVo);
    }

    @GetMapping("/search")
    Object card_search( Long uid,Date date) {
        return cardtableService.card_search(uid,date);
    }

    @GetMapping("/mycard")
    Object getMyCard( Long uid) {
        return cardtableService.getMyCard(uid);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器

    }
}
