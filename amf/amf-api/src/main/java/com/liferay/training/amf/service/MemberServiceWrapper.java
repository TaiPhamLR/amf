/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MemberService}.
 *
 * @author Brian Wing Shun Chan
 * @see MemberService
 * @generated
 */
public class MemberServiceWrapper
	implements MemberService, ServiceWrapper<MemberService> {

	public MemberServiceWrapper(MemberService memberService) {
		_memberService = memberService;
	}

	@Override
	public com.liferay.training.amf.model.Member addMember(
			long groupId, String firstName, String lastName,
			String emailAddress, boolean male, java.util.Date birthday,
			String password, String homePhone, String mobilePhone,
			String address1, String address2, String city, String state,
			String zipCode, String securityQuestion, String answer,
			boolean termOfUse,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberService.addMember(
			groupId, firstName, lastName, emailAddress, male, birthday,
			password, homePhone, mobilePhone, address1, address2, city, state,
			zipCode, securityQuestion, answer, termOfUse, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _memberService.getOSGiServiceIdentifier();
	}

	@Override
	public MemberService getWrappedService() {
		return _memberService;
	}

	@Override
	public void setWrappedService(MemberService memberService) {
		_memberService = memberService;
	}

	private MemberService _memberService;

}