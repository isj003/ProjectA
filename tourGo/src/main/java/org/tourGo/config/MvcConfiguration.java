package org.tourGo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer{
	
	@Value("${file.uploadPath}")
	private String fileUploadPath;
	
	@Override
	    public void addResourceHandlers(final ResourceHandlerRegistry registry){
	        registry.addResourceHandler("/**")
	                .addResourceLocations("classpath:/templates/", "classpath:/static/");

	        registry.addResourceHandler("/trip/uploads/**") //업로드 파일 경로 설정
	        		.addResourceLocations("file:///"+fileUploadPath+"/");
	    }	 

		//메시지식 설정
		@Bean
		public MessageSource messageSource() {
			ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
			ms.setBasenames("messages.community", "messages.common", "messages.user","messages.planner"); //메시지파일 여기에 추가하기
			ms.setDefaultEncoding("UTF-8");
			
			return ms;
		}
		//index 페이지를 메인페이지로 이동
		//http://localhost:3000/ → http://localhost:3000/main_view
		@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addRedirectViewController("/", "/main_view");
		}


}
