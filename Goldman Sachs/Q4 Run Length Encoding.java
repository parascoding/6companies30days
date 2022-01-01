class GfG
 {
	String encode(String s)
	{
          StringBuilder sb=new StringBuilder("");
          int count=1;
          int n=s.length();
          char last=s.charAt(0);
          sb.append(last);
          for(int i=1;i<n;i++)
          {
              if(s.charAt(i)!=last)
              {
                  last=s.charAt(i);
                  sb.append(count);
                  count=1;
                  sb.append(last);
              }
              else
              {
                  count++;
              }
          }
          sb.append(count);
          return sb.toString();
	}
	
 }
