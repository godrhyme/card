package com.example.card.Controller;

import com.example.card.Service.CardtableService;
import com.example.card.Vo.CardtableVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Card")
@RestController
public class CardtableController {

    @Autowired
    private CardtableService cardtableService;

    @PostMapping("/submit")
    Object card_submit(CardtableVo cardtableVo) {
        return cardtableService.card_submit(cardtableVo);
    }

    @GetMapping("/search")
    Object card_search(Long id) {
        return cardtableService.card_search(id);
    }

    @GetMapping("/mycard")
    Object getMyCard(Long uid) {
        return cardtableService.getMyCard(uid);
    }
}
