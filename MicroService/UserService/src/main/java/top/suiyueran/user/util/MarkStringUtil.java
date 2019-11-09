package top.suiyueran.user.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 20:37 2019/11/9
 * @Modifyed by:
 */
public class MarkStringUtil {
    /**
     * 日期格式
     */
    public final static String ateFarmat = "yyyyMMddHHmmss";

    public static String getUniqueCode() {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern(ateFarmat));
        Random random = new Random();
        int nextInt = random.nextInt(99999);
        return time + String.format("%05d", nextInt);
    }

}
