package com.reactnative.photoview.viewpager;

/**
 * Created by anthonyou on 2016-06-27.
 */

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;

/**
 * Event emitted by {@link ReactViewPager} when user scrolls between pages (or
 * when animating between pages).
 *
 * Additional data provided by this event: - position - index of first page from
 * the left that is currently visible - offset - value from range [0,1)
 * describing stage between page transitions. Value x means that (1 - x)
 * fraction of the page at "position" index is visible, and x fraction of the
 * next page is visible.
 */
/* package */ class PageScrollEvent extends Event<PageScrollEvent> {

    public static final String EVENT_NAME = "topPageScroll";

    private final int mPosition;
    private final float mOffset;

    protected PageScrollEvent(int viewTag, long timestampMs, int position, float offset) {
        super(viewTag);
        mPosition = position;
        mOffset = offset;
    }

    @Override
    public String getEventName() {
        return EVENT_NAME;
    }

    @Override
    public void dispatch(RCTEventEmitter rctEventEmitter) {
        rctEventEmitter.receiveEvent(getViewTag(), getEventName(), serializeEventData());
    }

    private WritableMap serializeEventData() {
        WritableMap eventData = Arguments.createMap();
        eventData.putInt("position", mPosition);
        eventData.putDouble("offset", mOffset);
        return eventData;
    }
}
