import com.alibaba.nacos.client.config.utils.MD5;

/**
 * @ClassNametestMD5
 * @Description
 * @Author 黄皓
 * @Date2020/7/22 19:53
 **/
public class testMD5 {
    public static void main(String[] args) {
        System.out.println(MD5.getInstance().getMD5String("      "));
    }
}
