package top.ahianzhang.realm;

/**
 * Created by AhianZhang on 2017/10/30.
 */
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import top.ahianzhang.model.Blogger;
import top.ahianzhang.service.IBloggerService;

import javax.annotation.Resource;

/**
 * 自定义Realm
 * @author ahianzhang
 *
 */
public class realm extends AuthorizingRealm{
    @Resource
    private IBloggerService bloggerService;
    /**
     * 为当前的登录的用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    /**
     * 验证当前登录的用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
      String username= (String) token.getPrincipal();

        Blogger blogger=bloggerService.getByUserName(username);
        if (blogger!=null){
            //将当前用户的信息保存到session中，不论对错，每次提交都会进行覆盖
            SecurityUtils.getSubject().getSession().setAttribute("CurrentUser",blogger);
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(blogger.getUsername(),blogger.getPassword(),"isthisnecessary");
        return authenticationInfo;
        }
        else {
            return null;
        }

    }

}
