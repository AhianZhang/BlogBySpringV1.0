package top.ahianzhang.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**加密工具
 * Created by AhianZhang on 2017/10/30.
 */
public class CryptographyUtil
{
    public static String md5(String str,String salt){
        return new Md5Hash(str,salt).toString();
    }

    public static void main(String[] args) {
        String password="123456";

        System.out.println("Md5加密："+CryptographyUtil.md5(password, "ahian"));

    }
}
