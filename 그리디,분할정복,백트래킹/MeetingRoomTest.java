package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting>{
	int start,end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if(this.end >o.end) return 1;
		if(this.end==o.end) return this.start-o.start;
		
		return -1;
	}

	@Override
	public String toString() {
		return "Meeting [start=" + start + ", end=" + end + "]";
	}
}
public class MeetingRoomTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		Meeting[] mt = new Meeting[N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			mt[i] = new Meeting(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		for(Meeting meeting: getSchedule(mt)) {
			System.out.println(meeting);
		}
	}
	
	
	static ArrayList<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> list = new ArrayList<Meeting>();
		Arrays.sort(meetings);
		list.add(meetings[0]);
		
		for(int i=0,size=meetings.length;i<size;i++) {
			if(list.get(list.size()-1).end <= meetings[i].start) {
				list.add(meetings[i]);
			}
		}
		return list;
	}
	
	
}
