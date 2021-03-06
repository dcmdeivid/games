package net.vidageek.games.regex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.vidageek.games.regex.task.RegexGame;
import net.vidageek.games.regex.test.infra.Person;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

final public class RegexGameTest {

	@Mock
	private Descriptions descriptions;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void allTasksMustHaveAnswers() {
		new Person("a", "b", "ab", "abc", "\\\\", "\\$", "abcdefg12345", "Ab5", "AbCdEfG6", "ab\\$cd\\^Ef\\\\G1",
				"[ab]", "[ab]d", "[abc]d", "[a-c]", "[a-cA-D]", "[0-2]", "[a-z]", "\\d", "\\da", "[\\da]", "\\s",
				"\\sa", "[\\sa]", "\\w", "\\wp", ".", "[^ab]", "[^ab]d", "[^abc]d", "\\D", "\\Da", "[^\\da]", "\\S",
				"\\Sa", "[^\\sa]", "\\W", "\\Wp", "a?", "[a-b]?", "a+", "[a-c]+", "[a-c]*", "a*", "a|b", "aa|bb|ab",
				"a{3}", "[a-c]{3}", "([a-z]+)", "([a-z]+).*", "([a-z]+)(.*)", "(([a-z]+)(.*)a)", "(a+)\\1", "(a+)\\1",
				"(a+)\\1").play(new RegexGame(descriptions));
	}

	@Test
	public void hasNextTaskReturnsTrueIfThereIsSuchTask() {
		RegexGame game = new RegexGame(descriptions);
		assertTrue(game.hasNextTask(0));
	}

	@Test
	public void hasNextTaskReturnsFalseIfThereIsNoSuchTask() {
		RegexGame game = new RegexGame(descriptions);
		assertFalse(game.hasNextTask(game.getSize() + 1));
	}

	@Test
	public void nextTaskReturnsNextTask() {
		RegexGame game = new RegexGame(descriptions);
		assertEquals(4, game.nextTask(3));
	}

}
