// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: stock.proto

package com.srini.protobuf.model;

public interface StockOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Stock)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 isin = 2;</code>
   * @return The isin.
   */
  int getIsin();

  /**
   * <code>int32 volume = 3;</code>
   * @return The volume.
   */
  int getVolume();
}
