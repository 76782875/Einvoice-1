import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;

import com.park.einvoice.common.Base64Tools;


public class TestFile {
	@Test
	public void testPdfFile(){
		FileInputStream fis = null;
		String base64String= "";
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String path=request.getSession().getServletContext().getRealPath("/WEB-INF/pdf/");
		byte[] b = null;
        try {
			fis = new FileInputStream(new File("E://forwork//电子发票//电子发票测试.pdf"));
			b = new byte[fis.available()];
			fis.read(b);
			base64String= Base64Tools.encode2String(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
        byte[] byte1 = Base64Tools.decode2Byte(base64String);
        FileOutputStream fos = null;
        try {
			fos = new FileOutputStream(new File(request.getSession().getServletContext().getRealPath(path + "a.pdf")));
			fos.write(byte1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
