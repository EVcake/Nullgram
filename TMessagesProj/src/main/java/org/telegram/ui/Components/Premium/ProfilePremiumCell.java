/*
 * Copyright (C) 2019-2024 qwq233 <qwq233@qwq2333.top>
 * https://github.com/qwq233/Nullgram
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with this software.
 *  If not, see
 * <https://www.gnu.org/licenses/>
 */

package org.telegram.ui.Components.Premium;

import static org.telegram.messenger.AndroidUtilities.dp;

import android.content.Context;
import android.graphics.Canvas;

import org.telegram.messenger.AndroidUtilities;
import org.telegram.ui.ActionBar.Theme;
import org.telegram.ui.Cells.TextCell;
import org.telegram.ui.Stars.StarsReactionsSheet;

public class ProfilePremiumCell extends TextCell {

    private final StarsReactionsSheet.Particles particles = new StarsReactionsSheet.Particles(StarsReactionsSheet.Particles.TYPE_RADIAL, 30);
    private final int colorKey;

    public ProfilePremiumCell(Context context, int type, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
        colorKey = type == 1 ? Theme.key_starsGradient1 : Theme.key_premiumGradient2;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        float cx = imageView.getX() + imageView.getWidth() / 2f;
        float cy = imageView.getPaddingTop() + imageView.getY() + imageView.getHeight() / 2f - dp(3);
        AndroidUtilities.rectTmp.set(
            cx - dp(16), cy - dp(16),
            cx + dp(16), cy + dp(16)
        );
        particles.setBounds(AndroidUtilities.rectTmp);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        particles.process();
        particles.draw(canvas, Theme.getColor(colorKey));
        invalidate();
        super.dispatchDraw(canvas);
    }
}
