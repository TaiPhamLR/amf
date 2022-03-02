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

package com.liferay.training.amf.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.amf.model.Member;
import com.liferay.training.amf.service.base.MemberLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the member local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.amf.service.MemberLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.training.amf.model.Member",
	service = AopService.class
)
public class MemberLocalServiceImpl extends MemberLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.training.amf.service.MemberLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.training.amf.service.MemberLocalServiceUtil</code>.
	 */
	
	public Member addMember(long groupId, String firstName, String lastName, String emailAddress, boolean male, Date birthday, 
			String password, String homePhone, String mobilePhone, String address1, String address2, String city, 
			String state, String zipCode, String securityQuestion, String answer, boolean termOfUse, ServiceContext serviceContext) throws PortalException {
		
		// validator
		
		// Get group and user
		Group group = groupLocalService.getGroup(groupId);
//		long userId = serviceContext.getUserId();
//		User user = userLocalService.getUser(userId);
		// Generate primary key for Member
		long amfId = counterLocalService.increment(Member.class.getName());
		Member member = createMember(amfId);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setEmailAddress(emailAddress);
		member.setMale(male);
		member.setBirthday(birthday);
		member.setPassword(password);
		member.setHomePhone(homePhone);
		member.setMobilePhone(mobilePhone);
		member.setAddress1(address1);
		member.setAddress2(address2);
		member.setCity(city);
		member.setState(state);
		member.setZipCode(zipCode);
		member.setSecurityQuestion(securityQuestion);
		member.setAnswer(answer);
		member.setTermOfUse(termOfUse);
		
		// persit member to database
		member = super.addMember(member);
		return member;
	}
}