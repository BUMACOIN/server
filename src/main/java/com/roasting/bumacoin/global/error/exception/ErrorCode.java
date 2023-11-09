package com.roasting.bumacoin.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    ALREADY_INITIALIZE_COIN(400, "COIN-400-1", "You Already Initialize Coin"),
    COIN_NO_STOCK(400, "COIN-400-2", "Coin No Stock"),
    DONT_HAVE_MONEY(400, "USER-400-1", "You Dont Have Money"),
    INVALID_BLOCKCHAIN_HASH(400, "BLOCKCHAIN-400-1", "Invalid BlockChain Hash"),
    EXPIRED_JWT(403, "TOKEN-403-1", "Expired Jwt"),
    INVALID_JWT(403, "TOKEN-403-2", "Invalid Jwt"),
    USER_NOT_LOGIN(403, "USER-403-1", "User Not Login"),
    ONLY_WRITE_CAN_ADMIN(403, "USER-403-3", "This Active Can Only Admin"),
    FAILED_AUTHENTICATION(401, "AUTHENTICATION-401-1", "Failed Authentication"),
    NOT_MEISTER_MEMBER(401, "AUTHENTICATION-401-2", "Not Meister Member"),
    USER_NOT_FOUND(404, "USER-404-1", "User Not Found"),
    WALLET_NOT_FOUND(404, "WALLET-404-1", "Wallet Not Found"),
    MEMBER_NOT_FOUND(404, "MEMBER-404-1", "Member Not Found"),
    APPLICATION_NOT_FOUND(404, "APPLICATION-404-1", "Application Not Found"),
    ALREADY_APPLICATION(400, "APPLICATION-400-1", "Already Application This Project"),
    FOLLOW_NOT_FOUND(404, "FOLLOW-404-1", "Follow Not Found"),
    ALREADY_FOLLOW(400, "FOLLOW-400-1", "Already Follow"),
    IS_NOT_WRITER(403, "WRITER-403-1", "Is Not Writer"),
    YOU_DONT_LIKE_BEFORE(400, "LIKE-400-1", "You Dont Like Before"),
    ALREADY_LIKE(400, "LIKE-400-1", "Already Like This Project"),
    NON_EXISTENT_PROJECT(404, "LiKE-404-1", "Non Existent Project"),
    NOTIFICATION_NOT_FOUND(404, "NOTIFICATION-404-1", "Notification Not Found"),

    // S3
    IMAGE_FAILED_SAVE(424, "IMAGE-424-1", "Image Failed Save"),
    IMAGE_NOT_FOUND(404, "IMAGE-404-1", "Image Not Found"),

    INTERNAL_SERVER_ERROR(500, "SERVER-500-1", "Internal Server Error"),
    ;

    private final int status;
    private final String code;
    private final String message;
}