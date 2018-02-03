package me.hanwook.game.api.v1.controller;

import me.hanwook.game.api.v1.param.CardsParam;
import me.hanwook.game.api.v1.result.CardsResult;
import me.hanwook.game.api.v1.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cards")
public class CardV1Controller {

    @Autowired
    private CardService cardService;

    /**
     * 카드 목록 조회
     * @param param
     * @return
     */
    @GetMapping
    public ResponseEntity<CardsResult> findCards(CardsParam param) {

        CardsResult cardsResult =  cardService.findCards(param);

        // 끝 페이지
        if(cardsResult.getTotalCount() <= (param.getOffset() + param.getSize())) {
            return new ResponseEntity<>(cardsResult, null, HttpStatus.OK);
        }

        return new ResponseEntity<>(cardsResult, null, HttpStatus.PARTIAL_CONTENT);
    }
}
