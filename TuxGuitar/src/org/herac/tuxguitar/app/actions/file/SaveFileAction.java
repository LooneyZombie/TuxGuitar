/*
 * Created on 17-dic-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.herac.tuxguitar.app.actions.file;

import org.eclipse.swt.SWT;
import org.herac.tuxguitar.app.TuxGuitar;
import org.herac.tuxguitar.app.actions.Action;
import org.herac.tuxguitar.app.actions.ActionData;
import org.herac.tuxguitar.app.actions.ActionLock;

/**
 * @author julian
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SaveFileAction extends Action{
	
	public static final String NAME = "action.file.save";
	
	public SaveFileAction() {
		super(NAME, AUTO_LOCK | AUTO_UPDATE | KEY_BINDING_AVAILABLE );
	}
	
	protected int execute(ActionData actionData){
		final String fileName = FileActionUtils.getFileName();
		if(fileName == null){
			return AUTO_UNLOCK;
		}
		TuxGuitar.instance().loadCursor(SWT.CURSOR_WAIT);
		new Thread(new Runnable() {
			public void run() {
				if(!TuxGuitar.isDisposed()){
					FileActionUtils.save(fileName);
					TuxGuitar.instance().loadCursor(SWT.CURSOR_ARROW);
					ActionLock.unlock();
				}
			}
		}).start();
		
		return 0;
	}
}
