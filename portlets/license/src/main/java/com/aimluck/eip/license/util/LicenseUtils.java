/*
 * Aipo is a groupware program developed by TOWN, Inc.
 * Copyright (C) 2004-2015 TOWN, Inc.
 * http://www.aipo.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aimluck.eip.license.util;

import org.apache.jetspeed.services.logging.JetspeedLogFactoryService;
import org.apache.jetspeed.services.logging.JetspeedLogger;
import org.apache.turbine.util.RunData;
import org.apache.velocity.context.Context;

import com.aimluck.eip.cayenne.om.account.AipoLicense;
import com.aimluck.eip.orm.Database;

/**
 * ライセンス情報のユーティリティクラスです
 */
public class LicenseUtils {

  /** logger */
  private static final JetspeedLogger logger = JetspeedLogFactoryService
    .getLogger(LicenseUtils.class.getName());

  public static final String LICENSE_PORTLET_NAME = "License";

  /**
   * AipoLicense オブジェクトモデルを取得します。
   * 
   * @param rundata
   * @param context
   * 
   * @return
   */
  public static AipoLicense getAipoLicense(RunData rundata, Context context) {

    try {
      return Database.query(AipoLicense.class).fetchSingle();
    } catch (Exception ex) {
      logger.error("license", ex);
      return null;
    }
  }
}
