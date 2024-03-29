package flow;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Dialog Designer at: 2006-JUN-20  02:10:12 PM
 */
public class transferdestination extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Dialog Designer at: 2006-JUN-20  02:10:12 PM
	 */
	public transferdestination() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: 2019-AUG-29  10:01:53 AM
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = new com.avaya.sce.runtime.Next("exit", "Default");
		next.setDebugId(35);
		return next;
	}
	
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2019-AUG-29  10:01:53 AM
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(5);
		actions.add(new com.avaya.sce.runtime.tracking.ReportInfo(com.avaya.sce.runtimecommon.IReportInfo.REPORT_TYPE_PROGRESS, com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_CRITICAL, "Log state of transfered call", "Transfer call state: ", "transfertoextn:state").setDebugId(115));
		actions.add(new com.avaya.sce.runtime.tracking.ReportInfo(com.avaya.sce.runtimecommon.IReportInfo.REPORT_TYPE_PROGRESS, com.avaya.sce.runtimecommon.IReportInfo.ALARM_LEVEL_CRITICAL, "state of original call", "Ctiinfo state: ", "").setDebugId(116));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "cticallinfo state:", "").setDebugId(118));
		actions.add(new com.avaya.sce.runtime.tracking.TraceInfo(com.avaya.sce.runtimecommon.ITraceInfo.TRACE_LEVEL_DEBUG, "transfer call state: ", "transfertoextn:state").setDebugId(119));

		//{{START:CODEGEN:EXTENSIONPOINT:com.avaya.sce.cti.ui.transfer
		actions.add(com.avaya.sce.runtime.connectivity.cti.CTIOpFactory.createTransferOperation(mySession, new com.avaya.sce.runtimecommon.VariableName("cticallinfo"), 
			new com.avaya.sce.runtimecommon.VariableName("transfertoextn")).setDebugId(37));
		//}}END:CODEGEN:EXTENSIONPOINT:com.avaya.sce.cti.ui.transfer

		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "transfertoextn:state", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "busy", false).setDebugId(130)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("callnotestablished", "extnbusy").setDebugId(131));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "transfertoextn:state", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "no answer", false).setDebugId(124)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("callnotestablished", "extnnoanswer").setDebugId(125));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "transfertoextn:state", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "unreachable", false).setDebugId(126)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("callnotestablished", "extnunreachable").setDebugId(127));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "transfertoextn:state", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "unknown", false).setDebugId(128)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("callnotestablished", "unknownerror").setDebugId(129));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: 2019-AUG-29  10:01:53 AM
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
}
