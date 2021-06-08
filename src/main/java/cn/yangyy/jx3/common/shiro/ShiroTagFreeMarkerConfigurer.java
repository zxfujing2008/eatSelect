package cn.yangyy.jx3.common.shiro;

import java.io.IOException;

import cn.yangyy.jx3.common.shiro.tag.ShiroTags;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

/**
 * Created by Administrator on 2016/3/15.
 */
public class ShiroTagFreeMarkerConfigurer extends FreeMarkerConfigurer {
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        super.afterPropertiesSet();
        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
    }

}
