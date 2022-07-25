import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadyaLabsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		driver.get("http://staging.radyalabs.id:7008/");

		// ---LOGIN---
		WebElement username = driver.findElement(By.id("app_login_form_username"));
		username.sendKeys("sa");
		WebElement password = driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/div/div/div/div/div/nz-spin/div/form/nz-form-item[2]/nz-form-control/div/div/nz-input-group/input"));
		password.sendKeys("qwerty@123");
		WebElement btnLogin = driver.findElement(By.id("app_login_form_btn_signin"));
		btnLogin.click();

		// ---MANAGE ROLE---
		driver.findElement(By.linkText("Manajemen Role")).click();
		String idRoleData = "AABBCCDD";
		String role = "AABBCCDD Role Test";
		
		
		//--add new role--
		WebElement addButtonRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-index/nz-page-header/nz-page-header-content/div/div/div[2]/button"));
		addButtonRole.click();
		WebElement idRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/form/div/nz-form-item[1]/nz-form-control/div/div/input"));
		idRole.sendKeys(idRoleData);
		WebElement namaRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/form/div/nz-form-item[2]/nz-form-control/div/div/input"));
		namaRole.sendKeys(role);
		WebElement permissionAudit = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/nz-card/div/div/div[1]/div[1]/div/label/span[1]/input"));
		permissionAudit.click();
		permissionAudit.click();
		WebElement permissionDashboard = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/nz-card/div/div/div[3]/div[1]/div/label/span[1]/input"));
		permissionDashboard.click();
		//scroll down
		js.executeScript("arguments[0].scrollIntoView();",permissionDashboard );
		WebElement btnSubmit = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/div/div[2]/button"));
		btnSubmit.click();
		
		
		//--search role---
		Thread.sleep(2000);
		WebElement searchBoxRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-index/nz-page-header/nz-page-header-content/div/div/div[1]/nz-input-group/span/input"));
		searchBoxRole.sendKeys(role);
		WebElement searchBtnRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-index/nz-page-header/nz-page-header-content/div/div/div[1]/nz-input-group/span/span/button"));
		searchBtnRole.click();
		WebElement tableRole = driver.findElement(By.tagName("table"));
		tableRole.findElement(By.tagName("button")).click();
		
		//--edit role--
		String namaRoleEditData = "AABBCCDD Role Test Edited";
		
		WebElement btnEditRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-detail/nz-card[1]/div[1]/div/div[2]/button[1]"));
		btnEditRole.click();
		WebElement namaRoleEdit = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/form/div/nz-form-item[2]/nz-form-control/div/div/input"));
		namaRoleEdit.clear();
		namaRoleEdit.sendKeys(namaRoleEditData);
		
		WebElement btnSimpanEdit = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-form/nz-spin/div/div/div[2]/button"));
		btnSimpanEdit.click();
		
		//--search role---
		WebElement searchBoxRoleEdit = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-index/nz-page-header/nz-page-header-content/div/div/div[1]/nz-input-group/span/input"));
		searchBoxRoleEdit.sendKeys(namaRoleEditData);
		WebElement searchBtnRoleEdit = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-index/nz-page-header/nz-page-header-content/div/div/div[1]/nz-input-group/span/span/button"));
		searchBtnRoleEdit.click();
		
		//--delete role--
		WebElement table3 = driver.findElement(By.tagName("table"));
		table3.findElement(By.tagName("button")).click();
		
		WebElement btnDeleteRole = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-role-management-detail/nz-card[1]/div[1]/div/div[2]/button[2]"));
		btnDeleteRole.click();
		
		WebElement acceptDelete = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-3\"]/div/div/div[2]/div/div/div[2]/button[2]"));
		acceptDelete.click();
		
		
		Thread.sleep(2000);
		
		// ---MASTER DATA CABANG---
		driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-sider/div/perfect-scrollbar/div/div[1]/ul/app-sider/li[6]/div[1]")).click();
		driver.findElement(By.partialLinkText("General")).click();
		driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-user-management-general/div/div/nz-card/div")).click();
		
		// master data cabang add new data
		String dataKodeCabang = "Zee31";
		String dataCabang = "Zee31 Cabang Test";
		String dataPJCabang = "Zeze";
		String dataEmailCabang = "zeze31@example.com";
		
		WebElement addButton = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-master-plant-index/nz-page-header/nz-page-header-content/div/div/div[2]/button"));
		addButton.click();
		
		WebElement kode = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-5\"]/nz-modal-container/div/div/div[2]/form/div/div[1]/nz-form-item/nz-form-control/div/div/input"));
		kode.sendKeys(dataKodeCabang);
		WebElement cabang = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-5\"]/nz-modal-container/div/div/div[2]/form/div/div[2]/nz-form-item/nz-form-control/div/div/input"));
		cabang.sendKeys(dataCabang);
		WebElement penanggungJawab = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-5\"]/nz-modal-container/div/div/div[2]/form/div/div[3]/nz-form-item/nz-form-control/div/div/input"));
		penanggungJawab.sendKeys(dataPJCabang);
		WebElement email = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-5\"]/nz-modal-container/div/div/div[2]/form/div/div[4]/nz-form-item/nz-form-control/div/div/input"));
		email.sendKeys(dataEmailCabang);
		
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-5\"]/nz-modal-container/div/div/div[3]/button[2]")).click();
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		// master data cabang edit data
		String dataEditPjCabang = "Zuzu";
		
		WebElement editButton = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-master-plant-index/nz-table/nz-spin/div/div/nz-table-inner-default/div/table/tbody/tr[1]/td[6]/button[2]"));
		editButton.click();
		WebElement penanggungJawabEdit = driver.findElement(By.xpath("//*[@id=\"cdk-overlay-1\"]/nz-modal-container/div/div/div[2]/form/div/div[3]/nz-form-item/nz-form-control/div/div/input"));
		penanggungJawabEdit.clear();
		penanggungJawabEdit.sendKeys(dataEditPjCabang);
		
		driver.findElement(By.xpath("//*[@id=\"cdk-overlay-1\"]/nz-modal-container/div/div/div[3]/button[2]")).click();
		
		driver.navigate().refresh();
		
		// master data cabang delete data
		driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-master-plant-index/nz-table/nz-spin/div/div/nz-table-inner-default/div/table/tbody/tr[1]/td[6]/button[1]")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[2]/div/div/div[2]/button[2]")).click();
		
		// master data cabang search
		WebElement searchBox = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-master-plant-index/nz-page-header/nz-page-header-content/div/div/div[1]/nz-input-group/span/input"));
		searchBox.sendKeys("TR12123");
		WebElement searchBtn = driver.findElement(By.xpath("/html/body/app-root/app-base/nz-layout/nz-layout/nz-content/app-master-plant-index/nz-page-header/nz-page-header-content/div/div/div[1]/nz-input-group/span/span/button"));
		searchBtn.click();
		
		
		Thread.sleep(2000);
		driver.close();
		driver.quit();

	}

}
