package com.google.sample.cast.refplayer.ui.channellist.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ChannelItemDecoration extends RecyclerView.ItemDecoration {
    private int sizeGridSpacingPx;
    private int gridSize;
    private boolean needLeftSpacing = false;

    public ChannelItemDecoration(int gridSpacingPx, int gridSize) {
        sizeGridSpacingPx = gridSpacingPx;
        this.gridSize = gridSize;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int frameWidth = (int) ((parent.getWidth() - (float) sizeGridSpacingPx * (gridSize - 1)) / gridSize);
        int padding = parent.getWidth() / gridSize - frameWidth;
        int itemPosition = ((RecyclerView.LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
        if (itemPosition < gridSize) {
            outRect.top = 0;
        } else {
            outRect.top = sizeGridSpacingPx;
        }
        if (itemPosition % gridSize == 0) {
            outRect.left = 0;
            outRect.right = padding;
            needLeftSpacing = true;
        } else if ((itemPosition + 1) % gridSize == 0) {
            needLeftSpacing = false;
            outRect.right = 0;
            outRect.left = padding;
        } else if (needLeftSpacing) {
            needLeftSpacing = false;
            outRect.left = sizeGridSpacingPx - padding;
            if ((itemPosition + 2) % gridSize == 0) {
                outRect.right = sizeGridSpacingPx - padding;
            } else {
                outRect.right = sizeGridSpacingPx / 2;
            }
        } else if ((itemPosition + 2) % gridSize == 0) {
            needLeftSpacing = false;
            outRect.left = sizeGridSpacingPx / 2;
            outRect.right = sizeGridSpacingPx - padding;
        } else {
            needLeftSpacing = false;
            outRect.left = sizeGridSpacingPx / 2;
            outRect.right = sizeGridSpacingPx / 2;
        }
        outRect.bottom = 0;
    }
}
