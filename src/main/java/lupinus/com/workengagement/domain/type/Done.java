package lupinus.com.workengagement.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * taskをやったかどうかを表す値オブジェクト.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Done {
  private final boolean value;

  public static Done from(boolean done) {
    return new Done(done);
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }

  public boolean toBoolean() {
    return this.value;
  }
}

