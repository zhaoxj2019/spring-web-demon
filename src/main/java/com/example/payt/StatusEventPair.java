package com.example.payt;

/**
 * @author 赵晓军
 * @since 2024/1/25
 */
public class StatusEventPair<S extends BaseStatus, E extends BaseEvent> {
    private final S status;
    private final E event;

    public StatusEventPair(S status, E event) {
        this.status = status;
        this.event = event;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StatusEventPair) {
            StatusEventPair<S, E> other = (StatusEventPair<S, E>)obj;
            return this.status.equals(other.status) && this.event.equals(other.event);
        }
        return false;
    }

    @Override
    public int hashCode() {
        // 这里使用的是google的guava包。com.google.common.base.Objects
        return com.google.common.base.Objects.hashCode(status, event);
    }

}
