/*
 * Kontalk Android client
 * Copyright (C) 2016 Kontalk Devteam <devteam@kontalk.org>

 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.kontalk.ui;

import com.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

import org.kontalk.authenticator.Authenticator;


public class ConversationsActivityTest extends ActivityInstrumentationTestCase2<ConversationsActivity> {

    private Solo solo;

    public ConversationsActivityTest() {
        super(ConversationsActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation());
        getActivity();
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void testOpenRegistration() throws Exception {
        solo.unlockScreen();
        // no account registered - wait for registration activity
        if (Authenticator.getDefaultAccount(getActivity()) == null) {
            assertTrue(solo.waitForActivity(NumberValidation.class));
        }
    }

}
