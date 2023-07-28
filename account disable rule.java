import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.sql.Types;
	import java.util.List;
	import sailpoint.api.SailPointContext;
	import sailpoint.connector.JDBCConnector;
	import sailpoint.object.Application;
	import sailpoint.object.ProvisioningPlan;
	import sailpoint.object.ProvisioningPlan.AccountRequest;
	import sailpoint.object.ProvisioningPlan.AttributeRequest;
	import sailpoint.object.ProvisioningPlan.PermissionRequest;
	import sailpoint.object.ProvisioningResult;
	import sailpoint.object.Schema;
	import sailpoint.tools.xml.XMLObjectFactory;
	import org.apache.commons.logging.LogFactory;
	import org.apache.commons.logging.Log;
	
	public String getAttributeRequestValue(AccountRequest acctReq, String attribute) {
		if ( acctReq != null ) {
			AttributeRequest attrReq = acctReq.getAttributeRequest(attribute);
			if ( attrReq != null ) {
				return attrReq.getValue();
			}
		}
		return null;
	}
	ProvisioningResult result = new ProvisioningResult();
	if ( plan != null ) {
		List accounts = plan.getAccountRequests();
		if (( accounts != null ) && ( accounts.size() > 0 )) {
			for ( AccountRequest account : accounts ) {
				try {
					if ( AccountRequest.Operation.Disable.equals( account.getOperation()) ) {
						PreparedStatement statement = connection.prepareStatement( "update accounts set disabled = ? where accountnumber = ?" );
						statement.setString(1, getAttributeRequestValue(account,"disabled"));
						statement.setString (2, (String) account.getNativeIdentity());						
						statement.executeUpdate();
						result.setStatus( ProvisioningResult.STATUS_COMMITTED );
					}
				}
				catch (SQLException e) {
					result.setStatus( ProvisioningResult.STATUS_FAILED );
					result.addError( e );
				}
			}
		}
	}
	return result;