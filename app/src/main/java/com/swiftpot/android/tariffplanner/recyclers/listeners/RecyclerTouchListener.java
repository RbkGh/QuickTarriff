package com.swiftpot.android.tariffplanner.recyclers.listeners;/**
 * Created by Rodney on 13-Mar-16.
 */

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

/**
 * Created by Ace Programmer Rbk<rodney@swiftpot.com> on 13-Mar-16
 * 6:05 PM
 */
public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{
    /**
     * Silently observe and/or take over touch events sent to the RecyclerView
     * before they are handled by either the RecyclerView itself or its child views.
     * <p/>
     * <p>The onInterceptTouchEvent methods of each attached OnItemTouchListener will be run
     * in the order in which each listener was added, before any other touch processing
     * by the RecyclerView itself or child views occurs.</p>
     *
     * @param rv
     * @param e  MotionEvent describing the touch event. All coordinates are in
     *           the RecyclerView's coordinate system.
     * @return true if this OnItemTouchListener wishes to begin intercepting touch events, false
     * to continue with the current behavior and continue observing future events in
     * the gesture.
     */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    /**
     * Process a touch event as part of a gesture that was claimed by returning true from
     * a previous call to {@link #onInterceptTouchEvent}.
     *
     * @param rv
     * @param e  MotionEvent describing the touch event. All coordinates are in
     */
    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    /**
     * Called when a child of RecyclerView does not want RecyclerView and its ancestors to
     * intercept touch events with
     * {@link ViewGroup#onInterceptTouchEvent(MotionEvent)}.
     *
     * @param disallowIntercept True if the child does not want the parent to
     *                          intercept touch events.
     * @see ViewParent#requestDisallowInterceptTouchEvent(boolean)
     */
    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
