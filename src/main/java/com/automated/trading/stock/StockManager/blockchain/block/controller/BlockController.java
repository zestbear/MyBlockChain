package com.automated.trading.stock.StockManager.blockchain.block.controller;

import com.automated.trading.stock.StockManager.blockchain.block.service.BlockService;
import com.automated.trading.stock.StockManager.util.api.ApiResponse;
import com.automated.trading.stock.StockManager.util.api.ApiResponseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BlockController {

    private final BlockService blockService;

    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    /**
     * Block 생성
     * member_id 사용하여 사용자와 연결
     * Linked List 자료구조 사용
     */
    @PostMapping("/block/{member_id}")
    public ApiResponse<String> createBlock(@PathVariable("member_id") int member_id) {
        try {
            blockService.createBlock(member_id);
        } catch (Exception e) {
            log.error(ApiResponseType.BAD_REQUEST.getMessage());
            return new ApiResponse<>(ApiResponseType.BAD_REQUEST);
        }
        return new ApiResponse<>(ApiResponseType.SUCCESS);
    }

}