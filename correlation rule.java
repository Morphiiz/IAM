import sailpoint.object.Identity;

String accountNumber = account.get("identitynumber");

int len = accountNumber.length();

if(len == 1){
	accountNumber = "0000000"+accountNumber;
}
	HashMap returnargs = new HashMap();
  
returnargs.put("identityName",accountNumber);
  return returnargs;