package lupinus.com.workengagement.domain.type;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * taskの識別子の値オブジェクト.
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
public class Id {
  private final int value;

  public static Id from(int id) {
    return new Id(id);
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }

  public int toInteger() {
    return this.value;
  }
}
