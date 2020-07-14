package com.example.card.Controller;

import com.example.card.Service.CardtableService;
import com.example.card.Vo.CardtavleVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/Card")
@RestController
public class CardtableController {

    private CardtableService cardtableService;

    @PostMapping("/submit")
    Object card_submit(CardtavleVo cardtavleVo) {
        return cardtableService.card_submit(cardtavleVo);
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
