class Solution {
	private static class Room implements Comparable<Room> {
		final int openTime;
		Room[] adjacent;
		Room next;

		Room() {
			openTime = Integer.MAX_VALUE;
		}

		Room(int openTime) {
			this.openTime = openTime;
			next = this; // indicates that this Room hasn't been approached yet
		}

		@Override
		public int compareTo(Room other) {
			return openTime - other.openTime;
		}
	}

	private static final Room DUMMY_ROOM = new Room();

	private static Room initRooms(int[][] moveTime) {
		int n = moveTime.length;
		int m = moveTime[0].length;
		Room[][] rooms = new Room[n][m];
		for (int i = 0; i < n; i++) {
			int[] mtRow = moveTime[i];
			Room[] rRow = rooms[i];
			for (int j = 0; j < m; j++)
				rRow[j] = new Room(mtRow[j]);
		}
		Room[] dummyRow = new Room[m];
		Arrays.fill(dummyRow, DUMMY_ROOM);
		Room[] prevRow = dummyRow;
		Room[] curRow = rooms[0];
		n--;
		m--;
		for (int i = 0; i <= n; i++) {
			Room[] nextRow = i < n ? rooms[i + 1] : dummyRow;
			Room prev = DUMMY_ROOM;
			Room cur = curRow[0];
			for (int j = 0; j <= m; j++) {
				Room next = j < m ? curRow[j + 1] : DUMMY_ROOM;
				cur.adjacent = new Room[] { prev, prevRow[j], next, nextRow[j] };
				prev = cur;
				cur = next;
			}
			prevRow = curRow;
			curRow = nextRow;
		}
		Room start = rooms[0][0];
		start.next = rooms[n][m]; // finish
		return start;
	}

	public static int minTimeToReach(int[][] moveTime) {
		Room start = initRooms(moveTime);
		Room finish = start.next;
		Queue<Room> waitingToEnter = new PriorityQueue<>();
		waitingToEnter.add(DUMMY_ROOM); // guard Room to prevent NPE
		start.next = null;
		Room exitingHead = start;
		int currentTime = 0;
		while (true) {
			Room exitingHeadNew = null;
			while (exitingHead != null) {
				for (Room adj : exitingHead.adjacent)
					if (adj.next == adj) {
						if (adj == finish)
							return Math.max(currentTime, finish.openTime) + 1;
						if (adj.openTime <= currentTime) {
							adj.next = exitingHeadNew;
							exitingHeadNew = adj;
						} else {
							adj.next = null;
							waitingToEnter.offer(adj);
						}
					}
				exitingHead = exitingHead.next;
			}
			exitingHead = exitingHeadNew;
			int queueTime;
			while ((queueTime = waitingToEnter.peek().openTime) <= currentTime) {
				Room entering = waitingToEnter.poll();
				entering.next = exitingHead;
				exitingHead = entering;
			}
			if (++currentTime < queueTime && exitingHead == null)
				currentTime = queueTime;
		}
	}
}
