package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @DisplayName("시간 단위 이용권은 사물함 이용이 불가능하다")
    @Test
    void shouldNot_LockerType_When_HourlyStudyPassType() {
        // given
        StudyCafePassType hourlyPassType = StudyCafePassType.HOURLY;

        // when & then
        assertThat(hourlyPassType.isLockerType()).isFalse();
        assertThat(hourlyPassType.isNotLockerType()).isTrue();
    }

    @DisplayName("주 단위 이용권은 사물함 이용이 불가능하다")
    @Test
    void shouldNot_LockerType_When_WeeklyStudyPassType() {
        // given
        StudyCafePassType hourlyPassType = StudyCafePassType.WEEKLY;

        // when & then
        assertThat(hourlyPassType.isLockerType()).isFalse();
        assertThat(hourlyPassType.isNotLockerType()).isTrue();
    }

    @DisplayName("1인 고정 이용권은 사물함 이용이 가능하다")
    @Test
    void should_LockerType_When_FixedStudyPassType() {
        // given
        StudyCafePassType hourlyPassType = StudyCafePassType.FIXED;

        // when & then
        assertThat(hourlyPassType.isLockerType()).isTrue();
        assertThat(hourlyPassType.isNotLockerType()).isFalse();
    }

}
