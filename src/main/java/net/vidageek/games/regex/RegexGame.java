package net.vidageek.games.regex;

import java.util.ArrayList;
import java.util.List;

import net.vidageek.games.Game;
import net.vidageek.games.GameController;
import br.com.caelum.vraptor.ioc.Component;

@Component
final public class RegexGame implements Game {

	private final List<Task> list;

	public RegexGame() {
		list = new ArrayList<Task>();
		list.add(new MatchingRegexTask("a", 0));
		list.add(new MatchingRegexTask("b", 1));
		list.add(new MatchingRegexTask("ab", 2));
		list.add(new MatchingRegexTask("abc", 3));
	}

	public Class<? extends GameController> beginClass() {
		return RegexGameController.class;
	}

	public Task task(final int index) {
		return list.get(index);
	}

	public int size() {
		return list.size();
	}

}