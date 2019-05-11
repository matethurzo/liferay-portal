<#include "copyright.txt" parse="false">

package ${apiPackagePath}.exception;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author ${author}
 */
@ProviderType
public class ${exception}Exception extends PortalException {

	public ${exception}Exception() {
	}

	public ${exception}Exception(String msg) {
		super(msg);
	}

	public ${exception}Exception(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ${exception}Exception(Throwable cause) {
		super(cause);
	}

}