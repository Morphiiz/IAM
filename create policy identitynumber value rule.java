import sailpoint.object.Identity;
import sailpoint.tools.Util;

String value="";
String employeeNumber = identity.getName();
int empNumber = Util.atoi(employeeNumber);
value = Util.itoa(empNumber);
return value;