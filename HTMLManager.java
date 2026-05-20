import javax.swing.text.html.HTML;
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

	public Queue <HTMLTag> getTags()
	{
		return tags;
	}

	public void fixHTML()
	{
		Stack <HTMLTag> tags = new Stack <>();
		int size = this.tags.size();
		for (int i = 0; i < size; i++)
		{
			HTMLTag cur = this.tags.remove();
			if (cur.isSelfClosing())
			{
				this.tags.add(cur);
			}
			else if (cur.isOpening())
			{
				this.tags.add(cur);
				tags.push(cur);
			}
			else if (cur.isClosing())
			{
				HTMLTag top = tags.pop();
				if (!top.equals(cur.getMatching()))
				{
					this.tags.add(cur.getMatching());
				}
			}
		}
		while (!tags.isEmpty())
		{
			this.tags.add(tags.pop().getMatching());
		}
	}

	public String toString()
	{
		String string = "";
		int size = tags.size();
		for (int i = 0; i < size; i++)
		{
			HTMLTag tag = tags.remove();
			string += tag;
			tags.add(tag);
		}
		return string;
	}
}