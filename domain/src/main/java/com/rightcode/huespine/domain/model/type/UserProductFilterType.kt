package com.rightcode.huespine.domain.model.type


enum class UserProductFilterType {
    SELLING, SELL_DONE, BUYING, BUY_DONE, SHAREING, SHARE_DONE, AUCTIONING, AUCTION_DONE;

    override fun toString(): String {
        return when (this) {
            com.rightcode.huespine.domain.model.type.UserProductFilterType.SELLING -> "sellIng"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.SELL_DONE -> "sellDone"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.BUYING -> "buyIng"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.BUY_DONE -> "buyDone"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.SHAREING -> "shareIng"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.SHARE_DONE -> "shareDone"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.AUCTIONING -> "auctionIng"
            com.rightcode.huespine.domain.model.type.UserProductFilterType.AUCTION_DONE -> "auctionDone"
        }
    }
}

