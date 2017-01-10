package org.mybatis.generator.extend.codegen.mybatis3.xmlmapper.elements;

import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * Created by Administrator on 2017/1/8.
 */
public class CountElementGenerator extends AbstractXmlElementGenerator {
    @Override
    public void addElements(XmlElement parentElement) {
        XmlElement answer = new XmlElement("select"); //$NON-NLS-1$
        answer.addAttribute(new Attribute("id", "count")); //$NON-NLS-1$
        answer.addAttribute(new Attribute("resultType", "java.lang.Long"));

        context.getCommentGenerator().addComment(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("select count(*) ");
        answer.addElement(new TextElement(sb.toString()));
        sb.setLength(0);
        sb.append("from "); //$NON-NLS-1$
        sb.append(introspectedTable
                .getAliasedFullyQualifiedTableNameAtRuntime());
        answer.addElement(new TextElement(sb.toString()));
        parentElement.addElement(answer);
    }
}
