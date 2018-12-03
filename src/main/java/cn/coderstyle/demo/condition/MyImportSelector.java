package cn.coderstyle.demo.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑定义要返回的组件
public class MyImportSelector implements ImportSelector {

	//返回值，就是要导入到容器中的组件全限定名
	//AnnotationMetadata:当前标注@Import注解的类的所有注解信息
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		return new String[] {"cn.coderstyle.demo.entity.Blue","cn.coderstyle.demo.entity.Yellow"};
	}

}
