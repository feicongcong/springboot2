package com.fcc.api.tools;

import org.apache.poi.xwpf.usermodel.*;

/**
 * @Description: word工具类
 * @Author: CC.F
 * @Date: 13:29 2018/8/12
 */
public class WordTools {
    private static final int TITLE_FONT_SIZE = 20;
    private static final int BODY_FONT_SIZE = 16;
    public static final String WORD_EXT = ".docx";

//    public static void createByTemplate(String savePath,List<DataModelDto>String fileName) {
//        XWPFDocument document = new XWPFDocument();
//        // 生成文件
////        File file = new File("F:\\sddev\\amount.docx");
//        File file = new File(savePath+fileName+WORD_EXT);
//        try (FileOutputStream out = new FileOutputStream(file)) {
//            setTitle(document, "标的信息");
//            setParagraph(document, "业务来源", "浙江格爱网络科技有限公司");
//            setParagraph(document, "借款人名称", "蔡璐璐");
//            setParagraph(document, "借款金额", "20000元");
//            setParagraph(document, "借款期限", "3个月");
//            // 页眉&页脚
//            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
//            XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);
//            // 添加页眉
//            CTP ctpHeader = CTP.Factory.newInstance();
//            CTR ctrHeader = ctpHeader.addNewR();
//            CTText ctHeader = ctrHeader.addNewT();
//            String headerText = "闪电系统.";
//            ctHeader.setStringValue(headerText);
//            XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
//            headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
//            XWPFParagraph[] parsHeader = new XWPFParagraph[1];
//            parsHeader[0] = headerParagraph;
//            policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);
//            // 添加页脚
//            CTP ctpFooter = CTP.Factory.newInstance();
//            CTR ctrFooter = ctpFooter.addNewR();
//            CTText ctFooter = ctrFooter.addNewT();
//            String footerText = "闪电系统";
//            ctFooter.setStringValue(footerText);
//            XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
//            footerParagraph.setAlignment(ParagraphAlignment.RIGHT);
//            XWPFParagraph[] parsFooter = new XWPFParagraph[1];
//            parsFooter[0] = footerParagraph;
//            policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
//            document.write(out);
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 设置标的文档标题
     *
     * @param document word对象
     */
    public static void setTitle(XWPFDocument document, String title) {
        // 添加标题
        XWPFParagraph titleParagraph = document.createParagraph();
        // 设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        titleParagraphRun.setText(title);
        titleParagraphRun.setFontSize(TITLE_FONT_SIZE);
        titleParagraphRun.setBold(true);
        // 换行
        document.createParagraph().createRun().setText("\r");
    }

    /**
     * 设置word段落
     *
     * @param document word对象
     */
    public static void setParagraph(XWPFDocument document, String key, String value) {
        // 段落
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun runKey = paragraph.createRun();
        runKey.setText(key + ": ");
        runKey.setFontSize(BODY_FONT_SIZE);
        runKey.setBold(true);
        XWPFRun runValue = paragraph.createRun();
        runValue.setText(value);
        runValue.setFontSize(BODY_FONT_SIZE);
        runValue.setUnderline(UnderlinePatterns.SINGLE);
        // 换行
        document.createParagraph().createRun().setText("\r");
    }

}
