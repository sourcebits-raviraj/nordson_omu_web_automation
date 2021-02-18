package com.nordson.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TemperatureRuntimeSettings {
	

	WebDriver ldriver;
	WebDriverWait wait;


	// Constructor of the LoginPage to initiate driver
	public TemperatureRuntimeSettings(WebDriver rdriver) {
		// TODO Auto-generated constructor stub

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "email")
	@CacheLookup
	WebElement EmailID;

	@FindBy(id = "pwd")
	@CacheLookup
	WebElement Password;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	@CacheLookup
	WebElement LoginButton;

	@FindBy(id = "bt")
	@CacheLookup
	WebElement SetUpToolButton;
	

	@FindBy(xpath = "//*[contains(text(),'CREATE NEW')]")
	@CacheLookup
	WebElement CreateNewButton;
	
	@FindBy(xpath = "//*[@class='btn-set-up submit-btn-color']")
	@CacheLookup
	WebElement SubmitButton;
	
	@FindBy(xpath = "//*[contains(text(),'System Settings')]")
	@CacheLookup
	WebElement SystemSettings;
	
	
	@FindBy(xpath = "//*[contains(text(),'Preferences')]")
	@CacheLookup
	WebElement Preferences;
	
	@FindBy(xpath = "//*[@id='mat-radio-2' and @value='0']//label/div[@class='mat-radio-container']")
	@CacheLookup
	WebElement Temperatureunit;
	
	@FindBy(xpath = "//*[@formcontrolname='TempUnits']/*[contains(@class,'mat-radio-checked')]//label//div")
	@CacheLookup
	WebElement SelectedTemperatureunit;
	
	@FindBy(xpath = "//*[@formcontrolname='TempUnits']//*[contains(text(),'C')]//preceding-sibling::div")
	@CacheLookup
	WebElement CelsiusTemperatureunit;
	
	@FindBy(xpath = "//*[@formcontrolname='TempUnits']//*[contains(text(),'F')]//preceding-sibling::div")
	@CacheLookup
	WebElement FarhenitTemperatureunit;
	
	@FindBy(xpath = "//*[@class='btn apply']")
	@CacheLookup
	WebElement SAVE;


	@FindBy(xpath = "//*[contains(text(),'Runtime settings')]")
	@CacheLookup
	WebElement RuntimeSettings;
	
	@FindBy(xpath = "//*[contains(text(),'ZONE TEMPERATURE')]")
	@CacheLookup
	WebElement ZoneTemperature; 
	
	@FindBy(xpath = "//*[contains(text(),'Global Setpoint')]/../following-sibling::tr/td//input")
	@CacheLookup
	WebElement GlobalSetPoint; 
	
	@FindBy(xpath = "//*[contains(text(),'Tank')]/../following-sibling::tr/td//input")
	@CacheLookup
	WebElement Tank; 
	
	@FindBy(xpath = "//*[contains(text(),'Manifold')]/../following-sibling::tr/td//input")
	@CacheLookup
	WebElement Manifold; 
	
	@FindBy(xpath = "//*[contains(text(),'Hose')]")
	@CacheLookup
	List<WebElement> Hose;
	
	@FindBy(xpath = "//*[contains(text(),'Applicator')]")
	@CacheLookup
	List<WebElement> Applicator;
	
	@FindBy(xpath = "//*[contains(@name,'hose')]")
	@CacheLookup
	List<WebElement> HoseSetpoint;
	
	@FindBy(xpath = "//*[contains(@name,'applicator')]")
	@CacheLookup
	List<WebElement> ApplicatorSetpoint;


	// Page Action Methods for all the WebElements declared
		public void setUserName(String username) {
			EmailID.sendKeys(username);

		}

		public void setPassword(String pass) {
			Password.sendKeys(pass);

		}

		public void clickLoginBtn() {
			LoginButton.click();

		}
		
		public void waitForLoginBtnEnable() {

			wait = new WebDriverWait(ldriver, 80);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Sign In']")));
		}

		public void loginBtnEnabled() {

			LoginButton.isEnabled();

		}

		
		public void SignIn() {
			LoginButton.click();

		}

		public void ClearUsername() {
			EmailID.clear();
		}

		public void ClearPassword() {
			Password.clear();
		}
		
		public void clickSetUpToolBtn() {
			SetUpToolButton.click();

		}
		
		public void SetUpToolBtnISEnabled() {
			try {
			wait = new WebDriverWait(ldriver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("bt")));
		   }
			
			catch(TimeoutException e) {
			       System.out.println("SetUp Tool Element isn't clickable");
			    }

		}
		public void CreateNewBtnISEnabled() {
			
			try {
			wait = new WebDriverWait(ldriver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'CREATE NEW')]")));
			
			}
			
			catch(TimeoutException e) {
			       System.out.println( "Create New Element isn't clickable");
			    }

		}
		
		
		public void clickCreateNewBtn() {
			CreateNewButton.click();

		}
		
		public void clickSubmitBtn() {
			SubmitButton.click();

		}
		
        public void SystemSettingsBtnISEnabled() {
			
			try {
			wait = new WebDriverWait(ldriver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'System Settings')]")));
			
			}
			
			catch(TimeoutException e) {
			       System.out.println("System Settings Element isn't clickable");
			    }

		  }		
		
		public void clickSystemSettingsBtn() {
			SystemSettings.click();

		}
		
		 public void PreferencesBtnISEnabled() {
				
				try {
				wait = new WebDriverWait(ldriver, 60);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Preferences')]")));
				
				}
				
				catch(TimeoutException e) {
				       System.out.println("System Settings Element isn't clickable");
				    }

			  }		
			
			public void clickPreferencesBtn() {
				Preferences.click();

			}
		
			  public  String getTemperatureunit() 
			  
			  {
				  System.out.println(Temperatureunit);
				  String tempunit=""; 
				  Boolean value=Temperatureunit.isSelected();
				  System.out.println("value"+ value);
				  if(Temperatureunit.isSelected()==true)
				  {
					 tempunit=SelectedTemperatureunit.getText();
					
				  }
				return tempunit;		
			  }	
			  
			  
			  public void clickCelsiusUnit()
			  {
				  
				  CelsiusTemperatureunit.click();
				  
			  }
			  
			  public void clickFarhenitUnit()
			  {
				  
				  FarhenitTemperatureunit.click();
				  
			  }
			  
			  public void clickSave()
			  {
				  
				  SAVE.click();
				  
			  }
			  
			  public void RuntimeSettingsBtnISEnabled() {
					
					try {
					wait = new WebDriverWait(ldriver, 60);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),' Runtime settings ')]")));
							}
				    catch(TimeoutException e) {
		                     System.out.println("System Settings Element isn't clickable");
					    }
				  }		
				
				public void  RuntimeSettingsBtn() {
					RuntimeSettings.click();

				}		
				
				
				 public void ZoneTemperatureBtnISEnabled() {
						
						try {
						wait = new WebDriverWait(ldriver, 60);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'ZONE TEMPERATURE')]")));
						
						}
						
						catch(TimeoutException e) {
						       System.out.println("System Settings Element isn't clickable");
						    }

					  }		
					
					public void ZoneTemperatureBtn()
				  {
				           ZoneTemperature.click();

				   }		
					
					
					public String getGlobalSetPoint() {
						String globalSetPoint=GlobalSetPoint.getAttribute("value");
						return globalSetPoint;	

					}
					
					public String getTankSetPoint() {
						String tanksetpoint=Tank.getAttribute("value");
						return tanksetpoint;
					}
					
					
					public String getManifold() {
						String manifold=Manifold.getAttribute("value");
						return manifold;
					}
					
					public List<Integer> getHoseEnableStatus()
					{
						String hose="";
						int hosewebelcunt = 0;
						List<Integer> hosecuntele=new ArrayList<Integer>();
						
					for(int i=1; i<=Hose.size();i++)
						{
						    hose ="//*[text()='Hose "+i+"']/following-sibling::td//*[not(contains(@class,'mat-checked'))]//input[@aria-checked='false']";
							hosewebelcunt=ldriver.findElements(By.xpath(hose)).size();
							hosecuntele.add(hosewebelcunt);
	
						}	
					
							return hosecuntele;
							
					}
					
					public List<Integer> getApplicatorEnableStatus()
					{
						String applicator="";
						int applicatorWebenblcunt=0;
						List<Integer> applicatorlscunt=new ArrayList<Integer>();
					    for(int i=1; i<=Applicator.size();i++)
						{
						    applicator ="//*[text()='Applicator "+i+"']/following-sibling::td//*[not(contains(@class,'mat-checked'))]//input[@aria-checked='false']";
						    applicatorWebenblcunt=ldriver.findElements(By.xpath(applicator)).size();
						    applicatorlscunt.add(applicatorWebenblcunt);
						    
						}
					        return applicatorlscunt;
					}
					
					public List<String> getHoseSetTemp()
					{
						String hosesetpnt="";
						List<String> Hosesetpointslst = new ArrayList<String>();
						
						 for(int i=1;i<=HoseSetpoint.size();i++)
						 {
						    hosesetpnt="//*[@name='hose"+i+"']";
						   WebElement el= ldriver.findElement(By.xpath(hosesetpnt));
						   String hosesettemppnt=el.getAttribute("value");
						   Hosesetpointslst.add(hosesettemppnt);
						   
						 }
						 
						 return Hosesetpointslst;
					}
					
					public List<String> getApplicatorSetTemp()
					{
						String applicatorsetpnt="";
						List<String> Applicatorsetpointslst = new ArrayList<String>();
						
						 for(int i=1;i<=Applicator.size();i++)
						 {
						    applicatorsetpnt="//*[@name='applicator"+i+"']";
						   WebElement el= ldriver.findElement(By.xpath(applicatorsetpnt));
						   String hosesettemppnt=el.getAttribute("value");
						   Applicatorsetpointslst.add(hosesettemppnt);
						   
						 }
						 
						 return Applicatorsetpointslst;
					}
					
}		

