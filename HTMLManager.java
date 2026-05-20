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
   
   public String toString() {
      String string = "";
      int size = tags.size();
      for (int i = 0; i < size; i ++) {
         HTMLTag tag = tags.remove();
         string += tag;
         tags.add(tag);
      }
      return string;
   }
}