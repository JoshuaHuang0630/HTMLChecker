import java.util.*;

public class HTMLManager
{
	private Queue <HTMLTag> tags;

	public HTMLManager(Queue <HTMLTag> html)
	{
		if (html == null)
		{
			throw new IllegalArgumentException();
		}
		for (HTMLTag tag : html)
		{
			tags.add(tag);
		}
	}
}
