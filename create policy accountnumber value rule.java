import sailpoint.object.Identity;
import sailpoint.tools.Util;

String accountName ="";
String employeeNumber = identity.getName();
int empNumber = Util.atoi(employeeNumber);
if(identity.getAttribute("employeetype").equalsIgnoreCase("Contractor")){
	accountName = "C"+Util.itoa(empNumber);
}else{
accountName = "A"+Util.itoa(empNumber);
}
return accountName;