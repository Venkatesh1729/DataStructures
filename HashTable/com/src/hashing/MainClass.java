package com.src.hashing;

public class MainClass
{

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("AaAaAa", "venkatesh");
		hashMap.put("AaAaBB", "sethu");
		hashMap.put("AaAaAa", "ragu");
		System.out.println(hashMap.get("AaAaBB"));
	}

}
