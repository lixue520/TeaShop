package cn.juntai.wxpaydemo.pay;

import cn.juntai.wxpaydemo.sdk.WXPayUtil;
import cn.juntai.wxpaydemo.util.DateUtil;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class WXPay {

    private static Log log = LogFactory.getLog(WXPay.class);

    private static final String PAY_SUCCESS = "SUCCESS";
    private static final String PAY_USERPAYING = "USERPAYING";

    public void UsePay() throws Exception {
        scanCodeToPay("133819286798799636");
        unifiedOrder();
    }

    public static void main(String[] args) throws Exception {

        // ���ɶ�ά�룬���֧��
        // unifiedOrder();
        // �̼�ɨ�û��ֻ���������
        scanCodeToPay("133819286798799636");
        unifiedOrder();
    }

    /**
     * ɨ��֧��
     *
     * @throws Exception
     */
    public static String scanCodeToPay(String auth_code) throws Exception {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();

        MyConfig config = new MyConfig();
        cn.juntai.wxpaydemo.sdk.WXPay wxpay = new cn.juntai.wxpaydemo.sdk.WXPay(config);
        String out_trade_no = DateUtil.getCurrentTime();
        Map<String, String> map = new HashMap<>(16);
        map.put("attach", "������������");
        map.put("auth_code", auth_code);
        map.put("body", "С���ֻ�");
        map.put("device_info", "���1�ŵ�");
        map.put("nonce_str", WXPayUtil.generateNonceStr());
        map.put("out_trade_no", out_trade_no);
        map.put("spbill_create_ip", spbill_create_ip);
        map.put("total_fee", "1");
        //����ǩ��
        String sign = WXPayUtil.generateSignature(map, config.getKey());
        map.put("sign", sign);
        String mapToXml = null;
        try {
            //����΢�ŵ�ɨ��֧���ӿ�
            Map<String, String> resp = wxpay.microPay(map);
            System.out.println("ɨ��֧�������" + resp);
            mapToXml = WXPayUtil.mapToXml(resp);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("΢��֧��ʧ��" + e);
        }
        //�ж�֧���Ƿ�ɹ�
        /*String return_code = null;
        String result_code = null;
        String err_code_des = null;
        String err_code = null;
        //��ȡDocument������Ҫ�ǻ�ȡ֧���ӿڵķ�����Ϣ��
        Document doc = DocumentHelper.parseText(mapToXml);
        //��ȡ����ĸ��ڵ�<xml>
        Element rootElement = doc.getRootElement();
        //��ȡ������ӽڵ�
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            if (element.getName().equals("return_code")) {
                return_code = element.getTextTrim();
            } else if (element.getName().equals("result_code")) {
                result_code = element.getTextTrim();
            } else if (element.getName().equals("err_code_des")) {
                err_code_des = element.getTextTrim();
            } else if (element.getName().equals("err_code")) {
                err_code = element.getTextTrim();
            }
        }*/
        /*if (PAY_SUCCESS.equals(return_code) && PAY_SUCCESS.equals(result_code)) {
            log.info("΢������֧���ɹ���");
            return PAY_SUCCESS;
        } else if (PAY_USERPAYING.equals(err_code)) {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(3000);
                Map<String, String> data = new HashMap<>(16);
                data.put("out_trade_no", out_trade_no);
                //����΢�ŵĲ�ѯ�ӿ�
                Map<String, String> orderQuery = wxpay.orderQuery(data);
                String orderResp = WXPayUtil.mapToXml(orderQuery);
                String trade_state = null;
                //��ȡDocument����
                Document orderDoc = DocumentHelper.parseText(orderResp);
                //��ȡ����ĸ��ڵ�<xml>
                Element rootElement1 = orderDoc.getRootElement();
                //��ȡ������ӽڵ�
                List<Element> elements1 = rootElement1.elements();
                for (Element element : elements1) {
                    if (element.getName().equals("trade_state")) {
                        trade_state = element.getTextTrim();
                    }
                }
                if (PAY_SUCCESS.equals(trade_state)) {
                    log.info("΢�ż���֧���ɹ���");
                    return PAY_SUCCESS;
                }
                log.info("����֧��" + orderResp);
            }
        }
        log.error("΢��֧��ʧ�ܣ�");*/
        return "";
    }

    /*
    �µ������ɶ�ά��
     */
    public static void unifiedOrder() {
        Map<String, String> resultMap = new HashMap();
        String openid = "ouR0E1oP5UGTEBce8jZ_sChfH26g";
        MyConfig config = null;
        cn.juntai.wxpaydemo.sdk.WXPay wxpay = null;
        try {
            config = new MyConfig();
            wxpay = new cn.juntai.wxpaydemo.sdk.WXPay(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //���ɵ�����ַ���
        String nonce_str = WXPayUtil.generateNonceStr();
        //��ȡ�ͻ��˵�ip��ַ
        //��ȡ������ip��ַ
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String spbill_create_ip = addr.getHostAddress();
        //֧������Ҫת���ַ������ͣ���������ǩ����ʧ��
        int total_fee = 1;//100�֣�1��Ǯ
        //��Ʒ����
        String body = "·����";
        //�̻�������
        String out_trade_no = WXPayUtil.generateNonceStr();
        //ͳһ�µ��ӿڲ���
        SortedMap<String, String> data = new TreeMap<String, String>();
        data.put("appid", "wxd9a46e74fc279fcc");
        data.put("body", body);
        data.put("mch_id", "1623889015");
        // �ص��ӿڣ�������һ������������ʹ��IP
        // ��Ѷ���Զ������㣨�����Լ��ṩ�Ľӿڣ��Ľӿڣ����㷢��֧����������ݣ����ݸ�ʽ��xml��ʽ
        data.put("notify_url", "http://4i802776s9.zicp.vip/result");
        data.put("out_trade_no", out_trade_no);//���׺�
        data.put("spbill_create_ip", spbill_create_ip);//�µ��ĵ���IP��ַ
        data.put("trade_type", "NATIVE");//֧������
        data.put("total_fee", String.valueOf(total_fee));
        //data.put("openid", openid);
        data.put("attach","id,11111;price,18.00;amount,1;");

        try {
            Map<String, String> rMap = wxpay.unifiedOrder(data);
            System.out.println("ͳһ�µ��ӿڷ���: " + rMap);
            createQRCode(rMap);//���ɶ�ά��
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createQRCode(Map<String, String> map) throws Exception {

        File outputFile = new File("src/main/java/ImageDemo" + File.separator + "new.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        String url = map.get("code_url");
        System.out.println("���ɶ�ά���url��" + url);
        try {
            Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, 300, 300, hints);

            MatrixToImageWriter.writeToStream(bitMatrix, "jpg", fileOutputStream);
        } catch (Exception e) {
            throw new Exception("���ɶ�ά��ʧ�ܣ�");
        } finally {
            fileOutputStream.close();
        }
    }
}