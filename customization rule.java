import sailpoint.object.ResourceObject;

boolean disabled = object.get("disabled");

if(disabled){
	object.put("IIQDisabled",true);
}

return object;